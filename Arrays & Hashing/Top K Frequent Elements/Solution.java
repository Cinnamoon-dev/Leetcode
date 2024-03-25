import java.util.HashMap;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Percorrer o array uma vez salvando as ocorrencias de cada indice em um hashmap
        // Percorrer k vezes as chaves do hashmap buscando a chave de maior valor e a colocando no vetor de retorno
        // Complexidade temporal: O(n + kc)
        // Onde c é o número de elementos únicos no array, k é a quantidade de elementos e n é o tamanho do array
        HashMap<Integer, Integer> elementOcurrences = new HashMap<>();
        int[] topk = new int[k];

        for (int i : nums) {
            if(!elementOcurrences.containsKey(i)) {
                elementOcurrences.put(i, 1);
            }

            elementOcurrences.put(i, elementOcurrences.get(i) + 1);
        }

        for (int i = 0; i < k; i++) {
            Integer mostOcurrences = 1;

            for (Integer j : elementOcurrences.keySet()) {
                if (elementOcurrences.get(j) > mostOcurrences) {
                    mostOcurrences = elementOcurrences.get(j);
                    topk[i] = j;
                }
            }

            elementOcurrences.remove(topk[i]);
        }

        return topk;
    }
}
