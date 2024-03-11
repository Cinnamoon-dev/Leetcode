# Valid Anagram - Easy
Eu pensei em dois approaches para resolver esse problema:
- Criar um hashmap a partir da palavra recebida, cada chave é uma letra e cada valor é um contador. Passar por cada caractere da palavra que é um possível anagrama e decrementar o contador de cada letra que for igual, se uma letra do possível anagrama não existir na palavra recebida retornar falso senão continuar até o final e checar se há algum contador no hashmap que seja diferente de zero se sim retorne falso, senão retorne verdadeiro.
- Criar dois arrays de chars um com cada palavra, ordene cada um e verifique se são iguais, se sim retornar verdadeiro, senão retornar falso

Primeiro algoritmo:
- Complexidade Temporal: O(n²)
- Complexidade Espacial: O(n)

Segundo algoritmo:
- Complexidade Temporal: Depende do algoritmo de ordenação
- Complexidade Espacial: Depende do algoritmo de ordenação, mas no mínimo O(n)