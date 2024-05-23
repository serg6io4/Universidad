-- =================================================
-- Colocar este fichero en el directorio Demos.Stack
-- Usar prelude> set -i../.. 
-- para localizar las pilas
-- =================================================
-- Examen sobre 1.25 ptos.
-- =================================================
import DataStructures.Stack.LinearStack
import Test.QuickCheck

-- ==================================================================
-- Ejercicio 1 (0.35 ptos.)
-- ========================= INFIX ==================================
-- Vamos a definir un tipo para representar expresiones infijas totalmente parentizadas
-- de enteros. (todas los operaciones van entre paréntesis)
-- Sea el siguiente tipo para representar expresiones aritméticas infijas (con paréntesis)
data InFix = Add | Dif | Mul | Value Integer | LeftP | RightP deriving (Eq,Show) 
type InFixExpression = [InFix]

-- Podemos construir expresiones como las siguientes:
-- sample1InFix1 corresponde con ((5 + ((6 + 2) * 2)) * 3)
sampleInFix1:: InFixExpression
sampleInFix1 = [ LeftP, LeftP, Value 5, Add, LeftP, LeftP, Value 6, Add, Value 2, RightP, Mul, Value 2, RightP, RightP, Mul, Value 3, RightP ]

-- sampleInFix2 se corresponde con la expresión ( (4 * 5) - 6)
sampleInFix2 :: InFixExpression
sampleInFix2 = [LeftP, LeftP, Value 4, Mul, Value 5,RightP, Dif, Value 6, RightP]

-- sample3 x y se corresponde con la expresión ((x * (y + (x * 2))) - y)
-- el resultado de sample3 4 3 es 41
sampleInFix3:: Integer -> Integer -> InFixExpression
sampleInFix3 x y = [LeftP, LeftP, Value x, Mul, LeftP, Value y, Add, LeftP,  Value x,
               Mul, Value 2, RightP, RightP, RightP, Dif, Value y, RightP]

-- Para evaluar una expresión infija se procede con la lista de
-- izquierda a derecha ayudado de dos pilas, una que almacena los valores (Stack Integer) 
-- y otra que almacena los operadores (Stack (Integer->Integer->Integer)). Se procede así:
-- Si aparece un paréntesis izquierdo (LeftP) se ignora y se sigue con el resto.
-- Si aparece un valor (Value x) se añade x a la pila de valores y se sigue con el resto.
-- Si aparece un constructor de operación, se incluye en la pila de operaciones 
-- la operación correspondiente. Por ejemplo, si aparece Add se añade (+).
-- Si aparece un paréntesis derecho es cuando se realiza la operacion. 
--      Se deben sacar sus dos operadores (primero el segundo y luego el primero)
--      de la pila de valores. Luego se saca el operador de la pila de operadores,
--      se opera y se guarda el resultado en la pila de valores.
-- Finalmente, cuando la lista esté vacía, la pila de valores debe contener el resultado.
-- NOTA: Suponemos que las expresiones infijas están bien formadas.


evaluateInFix :: InFixExpression -> Integer
evaluateInFix ex = evInFix ex empty empty

evInFix :: InFixExpression -> Stack (Integer->Integer->Integer) -> Stack Integer -> Integer
evInFix (LeftP:ex) stOp stDt = evInFix ex stOp stDt
evInFix ((Value v): ex) stOp stDt = evInFix ex stOp (push v stDt)
evInFix (Add:ex) stOp stDt  = evInFix ex (push (+) stOp) stDt
evInFix (Dif:ex) stOp stDt  = evInFix ex (push (-) stOp) stDt
evInFix (Mul:ex) stOp stDt  = evInFix ex (push (*) stOp) stDt
evInFix (RightP:ex) stOp stDt  = evInFix ex stOp' (push (op arg1 arg2) stDt'')
        where
            arg2   = top stDt
            stDt'  = pop stDt
            arg1   = top stDt'
            stDt'' = pop stDt'
            op     = top stOp
            stOp'  = pop stOp

evInFix [] stOp stDt = top stDt

{- Ejemplo de ejecución
> evaluateInFix sample1InFix1 
63

> evaluateInFix sampleInFix2
14

> evaluateInFix (sampleInFix3 4 3)
41
-}

-- ==================================================================
-- Ejercicio 2 (0.35 ptos.)
-- ============================= NPI ================================
-- Ahora vamos a representar expresiones en Notación Polaca Inversa
-- Sea el tipo siguiente para representar expresiones en notación polaca inversa
data NPI = ValueNPI Integer | AddNPI | DifNPI | MulNPI deriving (Eq, Show)
type NPIExpression = [NPI]

-- Podemos representar expresiones NPI como
-- sampleNPI1 corresponde con 5 6 2 + 2 * + 3 *
sampleNPI1:: NPIExpression
sampleNPI1 = [ValueNPI 5,ValueNPI 6,ValueNPI 2,AddNPI,ValueNPI 2,MulNPI,AddNPI,ValueNPI 3,MulNPI]

-- sampleNPI2 corresponde a 4 5 * 6 -
sampleNPI2:: NPIExpression
sampleNPI2 = [ValueNPI 4, ValueNPI 5 ,MulNPI,ValueNPI 6 ,DifNPI]

-- sampleNPI3 x y corresponde a: x y x 2 * + * y -
sampleNPI3 :: Integer -> Integer -> NPIExpression
sampleNPI3 x y = [ValueNPI x,ValueNPI y,ValueNPI x,ValueNPI 2,MulNPI,AddNPI,MulNPI,ValueNPI y,DifNPI]

-- Para evaluar una expresión de este tipo se procede de izquierda a la derecha 
-- usando una Pila de valores (Stack Integer)
-- Si aparece un valor (ValueNPI x) si añade x a la pila de valores.
-- Si aparece cualquier constructor de operador, se extrae de la pila de valores 
-- sus dos argumentos (primero el segundo y luego el primero), se opera con el operador
-- correspondiente y se añade el resultado a la pila de valores el resultado. 
-- Por ejemplo, si aparee AddNPI se suman los valores extraídos de la pila.
-- Si la lista está vacía en el tope de la pila está el resultado
-- NOTA: Las expresiones se suponen que están bien formadas.

evaluateNPI :: NPIExpression -> Integer
evaluateNPI ex = evNPI ex empty

evNPI :: NPIExpression -> Stack Integer -> Integer
evNPI [] st = top st
evNPI (ValueNPI x:xs) st = evNPI xs (push x st)
evNPI (op:xs) st = evNPI xs (push (make op a1 a2) st'')
    where
        a2 = top st
        st' = pop st
        a1 = top st'
        st'' = pop st'
        make :: NPI -> Integer -> Integer -> Integer
        make AddNPI x y = x+y
        make DifNPI x y = x-y
        make MulNPI x y = x*y

{- Ejemplos de uso
> evaluateNPI sampleNPI1
63

> evaluateNPI sampleNPI2
14

> evaluateNPI (sampleNPI3 4 3)
41
-}

-- ==================================================================
-- Ejercicio 3 (0.35 ptos.)
-- ==================== de NPI a InFix ==============================
-- Ahora se pretende crea una función que pase una expresión infija a una npi.
-- Para ello se necesita una pila donde guardaremos constructores de operaciones npi 
-- y se recorre la expresión infija de izquierda a derecha.
-- Si la lista está vacá en la cima de la pila está la expresión npi resultante.
-- Si aparece un paréntesis izquierdo se ignora y se sigue con el resto.
-- Si aparee un valor (Value x) se colecciona en la lista resultado y se sigue con el resto.
-- Si aparece un constructor de operador se almacena en la pila de operadores el operador npi 
-- correspondiente. (Ejemplo, si aparece Add se almacena AddNPI)
-- Si aparece un paréntesis derecho se extrae un operador de la pila y 
-- se colecciona en la lista. Se sigue con el resto. 

-- InFix
inFixToNPI :: InFixExpression -> NPIExpression
inFixToNPI ex = ifToNPI ex empty 

ifToNPI :: InFixExpression -> Stack NPI -> NPIExpression
ifToNPI [] stOp  = []
ifToNPI (LeftP:xs) stOp = ifToNPI xs stOp 
ifToNPI (Value x: xs) stOp = [ValueNPI x] ++ ifToNPI xs stOp
ifToNPI (Add:xs) stOp = ifToNPI xs (push AddNPI stOp) 
ifToNPI (Dif:xs) stOp = ifToNPI xs (push DifNPI stOp)
ifToNPI (Mul:xs) stOp = ifToNPI xs (push MulNPI stOp) 
ifToNPI (RightP:xs) stOp = op:ifToNPI xs stOp'
    where
        op = top stOp
        stOp' = pop stOp

{- Ejemplo de uso

> inFixToNPI sampleInFix1 == sampleNPI1

> inFixToNPI sampleInFix2 == sampleNPI2

> inFixToNPI (sampleInFix3 4 3) == sampleNPI3 4 3
-}

-- ==================================================================
-- EJERCICIO 4 (0.20 ptos.)
-- Crear una propiedad quickCheck que compruebe que la evaluacion  de (sampleInFix3 x y)
-- es lo mismo que la evaluación de la transformación de (sampleInFix3 x y) a NPI.

p1 x y = evaluateInFix (sampleInFix3 x y) == evaluateNPI (inFixToNPI (sampleInFix3 x y))