.include "inter.inc"
.include "notas.inc"

.data
.include "vader.inc"

buzz: 	.word 		 0

nota: 	.word 		-1

/* guia bits 	  10987654321098765432109876543210 */
leds:	.word	0b00000000000000000000001000000000	
	.word	0b00000000000000000000010000000000
	.word	0b00000000000000000000100000000000
	.word	0b00000000000000100000000000000000
	.word	0b00000000010000000000000000000000
	.word	0b00001000000000000000000000000000
	
ledAct: .word 		-1

.text

/*PI3*/
	mrs r0, cpsr
	mov r0, #0b11010011 @Modo SVC, FIQ&IRQ desact
	msr spsr_cxsf, r0
	add r0, pc, #4
	msr ELR_hyp, r0
	eret
	
/*Vector Interrupcion*/
	mov r0, #0
	ADDEXC 0x18, irq_handler @vector para irq
	ADDEXC 0x1c, fiq_handler @vector para fiq
	
/*Iniciar PILA*/
	mov r0, # 0b11010001 @ Modo FIQ, FIQ & IRQ desact
	msr cpsr_c, r0
	mov sp, # 0x4000
	mov r0, # 0b11010010 @ Modo IRQ, FIQ & IRQ desact
	msr cpsr_c, r0
	mov sp, # 0x8000
	mov r0, # 0b11010011 @ Modo SVC, FIQ & IRQ desact
	msr cpsr_c, r0
	mov sp, # 0x8000000
	
/* Ponemos como salida todos los GPIO, excepto los de los botones, que son entradas */
	ldr r0, =GPBASE
/* guia bits       xx999888777666555444333222111000 */
	ldr r1, =0b00001000000000000001000000000000 @ Configuramos los GPIO 9, 4
	str r1,[r0, #GPFSEL0]
/* guia bits       xx999888777666555444333222111000 */
	ldr r1, =0b00000000001000000000000000001001 @ Configuramos los GPIO 10, 11, 17
	str r1,[r0, #GPFSEL1]
/* guia bits       xx999888777666555444333222111000 */
	ldr r1, =0b00000000001000000000000001000000 @Configuramos los GPIO 22, 27
	str r1,[r0, #GPFSEL2]
	
/*Habilitar GPIO Interrupciones*/
/* guia bits       10987654321098765432109876543210 */
	ldr r0, =GPBASE
	mov r1, #0b00000000000000000000000000001100
	str r1, [r0, #GPFEN0]
	
/*Habilitar Interrupciones*/
	ldr r0, =INTBASE
	mov r1, #0b00000000000100000000000000000000
	str r1, [r0, # INTENIRQ2]
	mov r0, # 0b01010011 @ Modo SVC, IRQ activo
	msr cpsr_c, r0
	
/*Habilitar Intrrupciones de C1 para IRQ(Cambio de estado)*/
	ldr r0, =INTBASE
	mov r1, #0b0010
	str r1, [r0, # INTENIRQ1]
	
/*Habilitar Interrupciones de C3 para FIQ*/
	mov r1, # 0b10000011
	str r1, [r0, # INTFIQCON]
	
/*Habilitar Globalmente*/
	mov r0, # 0b00010011 @ Modo SVC, IRQ activo
	msr cpsr_c, r0
	
/*Programar C1*/
	ldr r0, =STBASE
	ldr r1, [r0, #STCLO]
	add r1,#5
	str r1, [r0, #STC1]
	
/*Programar C3*/
	ldr r0, =STBASE
	ldr r1, [r0, #STCLO]
	add r1, r1, #10
	str r1, [r0, #STC3]
	
	mov r5, #0
	mov r4, #0
	
	bucle:  b bucle
	
/*Rutina de Tratamiento*/
irq_handler:
	push {r0,r1,r2}
	
	ldr r0, =STBASE
	ldr r1, [r0,#STCLO]
	ldr r2, [r0,#STC1]
	cmp r2, r1
	bgt boton
calc:
	ldr r0, =nota
	ldr r1, [r0]
	cmp r1, #70
	moveq r1, #0
	addne r1, #1
	str r1, [r0]
	
	ldr r0, =GPBASE
/* Apago todos LEDs 10987654321098765432109876543210 */
	ldr r1, = 0b00001000010000100000111000000000
	str r1, [r0, #GPCLR0]
	
	cmp r5, #0
	beq fila
	
	cmp r5, #1
	beq rotacion
	
fila:
	ldr r0, =duratFS
	ldr r1, =nota
	ldr r2, [r1]
	ldr r2, [r0, r2, LSL #2]
	
	ldr r0,=STBASE
	mov r1,#0b0010
	str r1,[r0,#STCS]
	
	ldr r1, [r0, #STCLO]
	add r1, r2, r1
	str r1, [r0, #STC1]
	
	ldr r0, =GPBASE
	cmp r4, #0
	ldr r6, =0b00001000010000100000111000000000
	streq r6, [r0,#GPSET0]
	moveq r4, #1
	movne r4, #0
	
	
	pop { r0, r1, r2 }
	subs pc, lr, #4
rotacion:
	ldr r0, =ledAct
	ldr r1, [r0]
	cmp r1, #5
	moveq r1, #0
	addne r1, #1
	str r1, [r0]
	
	ldr r0, =leds
	ldr r2, [r0, r1, LSL #2]
	ldr r0, =GPBASE
	str r2, [r0, #GPSET0]
	
	ldr r0, =duratFS
	ldr r1, =nota
	ldr r2, [r1]
	ldr r2, [r0, r2, LSL #2]
	ldr r0,=STBASE
	mov r1,#0b0010
	str r1,[r0,#STCS]
	
	ldr r1, [r0, #STCLO]
	add r1, r2, r1
	str r1, [r0, #STC1]

	pop { r0, r1, r2 }
	subs pc, lr, #4
	
boton:
	ldr r0, =GPBASE
	ldr r1,[r0, #GPEDS0]
/*Compruebo si se ha pulsado el boton 2 (izq)*/
	ands r1, #0b00000000000000000000000000000100
	moveq r5, #0
	movne r5, #1
	
/*Desactivar las flags de las posbiles entradas y volver al programa*/
	ldr r0, =GPBASE
	mov r1, # 0b11111111111111111111111111111111
	str r1, [ r0, # GPEDS0 ]
	pop { r0, r1 }
	subs pc, lr, #4
	
fiq_handler:
	ldr r8, =buzz
	ldr r9, [r8]
	/*          10987654321098765432109876543210 */
	ldr r10, =0b00000000000000000000000000010000
	ldr r11, =GPBASE
	cmp r9, #0
	streq r10, [r11, #GPSET0]
	moveq r9, #1
	strne r10, [r11, #GPCLR0]
	movne r9, #0
	str r9, [r8]
	
/*Preparamos la proxima Interrupcion*/
	ldr r8, =STBASE
	mov r10, #0b1000
	str r10, [r8,#STCS]
	
	ldr r8, =notaFS
	ldr r9, =nota
	ldr r10, [r9]
	
	ldr r9, [r8, r10, LSL #2]
	
	ldr r8, = STBASE
	ldr r10, [ r8, # STCLO ]
	add r10, r9
	str r10, [ r8, # STC3 ]
	
	subs pc, lr, #4