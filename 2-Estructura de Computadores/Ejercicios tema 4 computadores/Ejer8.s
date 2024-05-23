.include "inter.inc"
.text
.data  
ledst : .word 0
/* Agrego vector interrupci �n */
	ADDEXC 0x18, irq_handler
/* Inicializo la pila en modos IRQ y SVC */
	mov r0, # 0b11010010 @ Modo IRQ, FIQ&IRQ desact
	msr cpsr_c, r0
	mov sp, # 0x8000
	mov r0, # 0b11010011 @ Modo SVC, FIQ&IRQ desact
	msr cpsr_c, r0
	mov sp, # 0x8000000
/* Configuro GPIO 9 como salida */
	ldr r0, = GPBASE
/* guia bits xx999888777666555444333222111000 */
	mov r1, # 0b00001000000000000000000000000000
	str r1, [r0, # GPFSEL0 ]
/* Programo contador C1 para futura interrupci�n */
	ldr r0, = STBASE
	ldr r1, [r0, # STCLO ]
	add r1, # 0x2 @ 2 microsegundos
	str r1, [r0, # STC1 ]
/* Habilito interrupciones, local y globalmente */
	ldr r0, = INTBASE
	mov r1, # 0b0010
	str r1, [r0, # INTENIRQ1 ]
	mov r0, # 0b01010011 @ Modo SVC, IRQ activo
	msr cpsr_c, r0
/* Repetir para siempre */
bucle : b bucle
/* Rutina de tratamiento de interrupci �n */
irq_handler :
	push {r0, r1, r2}
/* Conmuto variable de estado del LED */
	ldr r0, = ledst @ Leo puntero a v. ledst
	ldr r1, [r0] @ Leo variable
	eors r1, #1 @ Invierto bit 0, act. flag Z
	str r1, [r0] @ Escribo variable
/* Enciendo o apago todos los LEDs en funci �n del flag Z */
	ldr r0, = GPBASE
/* guia bits        10987654321098765432109876543210 */
	ldr r1, = 0b00000000000000000000001000000000
	streq r1, [r0, # GPSET0 ]
	strne r1, [r0, # GPCLR0 ]
/* Reseteo estado interrupci �n de C1 */
	ldr r0, = STBASE
	mov r1, # 0b0010
	str r1, [r0, # STCS ]
/* Programo siguiente interrupci �n medio segundo despu �s */
	ldr r1, [r0, # STCLO ]
	ldr r2, = 500000 @1 Hz
	add r1, r2
	str r1, [r0, # STC1 ]
/* Recupero registros y salgo */
	pop {r0, r1, r2}
	subs pc, lr, #4
