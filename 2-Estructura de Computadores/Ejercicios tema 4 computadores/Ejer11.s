.include "inter.inc"
	.text
	@FUNCIONA :DDDD

	/* Agrego vector interrupción */ 
	ADDEXC 0x18, irq_handler

	/* Inicializo la pila en modos IRQ y SVC */ 
	mov r0, #0b11010010 @ Modo IRQ, FIQ&IRQ desact
	msr cpsr_c, r0
	mov sp, #0x8000 

	mov r0, #0b11010011 @ Modo SVC, FIQ&IRQ desact 
	msr cpsr_c, r0 
	mov sp, #0x8000000

	/* Configuro GPIOs 4, 9, 10, 11, 17, 22 y 27 como salida */ 
	ldr r0, =GPBASE
	ldr r1, =0b00001000000000000001000000000000 
	str r1, [r0, #GPFSEL0]

	/* guia bits xx999888777666555444333222111000*/ 
	ldr r1, =0b00000000001000000000000000001001 
	str r1, [r0, #GPFSEL1]

	ldr r1, =0b00000000001000000000000001000000 
	str r1, [r0, #GPFSEL2]

	/* Programo C1 y C3 para dentro de 200000 microsegundos */
	ldr r0, =STBASE 
	ldr r1, [r0, #STCLO]
	ldr r2, =200000
	add r1, r2 
	str r1, [r0, #STC1] 
	str r1, [r0, #STC3]

	/* Habilito interrupciones, local y globalmente */ 
	ldr r0, =INTBASE
	mov r1, #0b1010 
	str r1, [r0, #INTENIRQ1] 
	mov r0, #0b01010011 @ Modo SVC, IRQ activo 
	msr cpsr_c, r0
	
	ldr     r5, =leds
	sub    r5, r5, #4
	
	/* Repetir para siempre */
	bucle: b bucle

    
	/* Rutina de tratamiento de interrupción */ 
	irq_handler: 
	push {r0, r1, r2, r3}

	/* Leo origen de la interrupción */
	ldr r0, =STBASE 
	ldr r1, =GPBASE
	ldr r2, [r0, #STCS]
	ands r2, #0b0010
	beq sonido

	/* Si es C3, ejecuto secuencia de LEDs */
        ldr    r2, [r5]
        str    r2, [r1, #GPCLR0]
        add    r6, r6, #1
        cmp    r6, #7
        ldreq    r5, =leds
        ldreq    r6, =1
        addne    r5, r5, #4
        ldr    r2, [r5]
        str    r2, [r1, #GPSET0]

	/* Reseteo estado interrupción de C1 */
	mov r3, #0b0010
	str r3, [r0, #STCS]

	/* Programo siguiente interrupción en 200ms */ 
	ldr r3, [r0, #STCLO] 
	ldr r2, =200000 @ 5 Hz 
	add r3, r2
	str r3, [r0, #STC1]                                                   

	/* ¿Hay interrupción pendiente en C3? */ 
	/* Si es C3, hago sonar el altavoz */ 
	
	sonido:
	ldr r2, =bitson
	ldr r3, [r2] 
	eors r3, #1 @ Invierto estado
	str r3, [r2]

	mov r3, #0b10000 @ GPIO 4 (altavoz) 
	streq r3, [r1, #GPSET0] @ Escribo en altavoz 
	strne r3, [r1, #GPCLR0] @ Escribo en altavoz

	/* Reseteo estado interrupción de C3 */ 
	mov r3, #0b1000 
	str r3, [r0, #STCS]                                                    

	/* Programo interrupción para sonido de 440 Hz */ 
	ldr r3, [r0, #STCLO] 
	ldr r2, =1136 @ Contador para 440 Hz 
	add r3, r2
	str r3, [r0, #STC3]                                                   

	/* Recupero registros y salgo */ 
	pop {r0, r1, r2, r3} 
	subs pc, lr, #4

	bitson: .word 0 @ Bit 0 = Estado del altavoz 
	leds: 
	.word 0b1000000000000000000000000000
	.word 0b0000010000000000000000000000
	.word 0b0000000000100000000000000000 
	.word 0b0000000000000000100000000000
	.word 0b0000000000000000010000000000 
	.word 0b0000000000000000001000000000