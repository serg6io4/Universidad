        .set    GPBASE,   0x3F200000

        .set    GPFSEL0,        0x00

	.set    GPFSEL1,        0x04

	.set    GPFSEL2,        0x08

        .set    GPSET0,         0x1c

        .set    GPCLR0,         0x28

	.set	GPLEV0,		0x34

	.set    STCLO,          0x04

	.set    STBASE,   0x3F003000


.text
	
mov 	r0, #0b11010011

	msr	cpsr_c, r0

	mov 	sp, #0x8000000
	


        ldr     r0, =GPBASE

/* guia bits           xx999888777666555444333222111000*/

        ldr   	r1, =0b00001000000000000001000000000000

        str	r1, [r0, #GPFSEL0]  @ Configura GPIO 9 y 4

	
        ldr     r0, =GPBASE

/* guia bits           xx999888777666555444333222111000*/

        ldr   	r1, =0b00000000001000000000000000000000

        str	r1, [r0, #GPFSEL1]  @ Configura GPIO 17



/* guia bits           10987654321098765432109876543210*/

        ldr	r5, =0b00000000000000000000000000010000

        ldr	r8, =STBASE	@ r0 es un parametro de sonido (dir base ST)


	

bucle:	
	ldr	r1, [r0, #GPLEV0]

	ands	r2, r1, #0b00000000000000000000000000000100

	beq	pulsador1

	ands	r2, r1, #0b00000000000000000000000000001000

	beq	pulsador2

	b 	bucle
	



pulsador1:	


/* guia bits           10987654321098765432109876543210*/

        ldr  	r1, =0b00000000000000000000001000000000

        str     r1, [r0, #GPSET0]   @ Enciende GPIO 9

/* guia bits           10987654321098765432109876543210*/

        ldr   	r1, =0b00000000000000100000000000000000

        str     r1, [r0, #GPCLR0]   @ Apaga GPIO 17

	ldr r1, =1000

	
b sonar



	
pulsador2:


/* guia bits           10987654321098765432109876543210*/

        ldr  	r1, =0b00000000000000100000000000000000

        str     r1, [r0, #GPSET0]   @ Enciende GPIO 17

/* guia bits           10987654321098765432109876543210*/
        ldr   	r1, =0b00000000000000000000001000000000

        str     r1, [r0, #GPCLR0]   @ Apaga GPIO 22

	ldr r1, =500

	
b sonar


sonar:


	str r5, [r0, #GPSET0]

	bl     	sonido		@ Salta a rutina de sonido

      
  str     r5, [r0, #GPCLR0]

	bl     	sonido 		@ Salta a rutina de sonido

	

ldr	r3, [r0, #GPLEV0]

	ands	r2, r3, #0b00000000000000000000000000000100

	beq	pulsador1

	ldr	r3, [r0, #GPLEV0]

	ands	r2, r3, #0b00000000000000000000000000001000

	beq	pulsador2

	
	b sonar

sonido: 
	
	push	{r4,r5}

        ldr     r4, [r8, #STCLO]  @ Lee contador en r4

        add    	r4, r1    	  @ r4= r4 + perido/2
ret1:
 	ldr     r5, [r8, #STCLO]

        cmp	r5, r4            @ Leemos CLO hasta alcanzar

        blo     ret1              @ el valor de r4

	pop	{r4,r5}

        bx      lr
	
	

