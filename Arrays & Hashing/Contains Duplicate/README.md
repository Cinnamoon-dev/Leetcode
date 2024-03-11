# Contains Duplicate - Easy
Podem-se tomar dois approaches para resolver esse problema:
- Comparar cada elemento da lista com todos os outros
- Criar um hashmap e ir adicionando cada elemento nele e checando se o próximo já existe no hashmap

Primeiro Método:
- Complexidade Temporal: O(n²)
- Complexidade Espacial: O(1)

Segundo Método:
- Complexidade Temporal: O(n)
- Complexidade Espacial: O(n)

Normalmente para se reduzir a complexidade temporal de um algoritmo se aumenta a complexidade espacial.