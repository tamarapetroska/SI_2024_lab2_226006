# Втора лабораториска вежба по Софтверско инженерство
## Тамара Петроска, 226006
### Control Flow Graph
![download](https://github.com/tamarapetroska/SI_2024_lab2_226006/assets/166302910/63f9429a-8497-4cab-a812-9792ed3b61a4)
### Цикломатска комплексност
Цикломатската комплексност на овој код е 10, ја добив со формулите:

E-N+2=10, каде E=36 е бројот на ребра, N=28 е бројот на јазли

P+1=9+1=10, каде P=9 е бројот на предикатни јазли

R=10 е бројот на региони

### Тест случаи според Every Branch критериумот
![Every Branch](https://github.com/tamarapetroska/SI_2024_lab2_226006/assets/166302910/d0f89a04-11e4-48de-ade4-a5df49f4469e)

### Тест случаи според Multiple Condition критериумот
![Multiple Condition](https://github.com/tamarapetroska/SI_2024_lab2_226006/assets/166302910/4564a765-e8dc-4c9d-89a5-fad4ad0fbc2c)

### Објаснување на напишаните unit tests
Every Branch

//null allItems list

Овој тест проверува дали методот правилно фрла исклучок кога allItems е null

//no discount

Овој тест проверува дали има item без попуст. Вкупната исплата (200) е поголема од сумата (100), па методот треба да врати true

//item with null name, discount > 0, special discount condition, and sum greater than payment

//item without barcode

Овој тест проверува дали методот фрла исклучок кога нема баркод

//invalid character in barcode

Овој тест проверува дали методот фрла исклучок кога има невалиден знак во баркодот

Multiple Condition

//T, T, T

//T, T, F

Овој тест проверува дали методот ќе фрли исклучок кога баркодот не почнува со '0'

//T, F, X

Овој тест проверува дали има попуст

//F, X, X

Овој тест проверува дали сумата е поголема од 300
