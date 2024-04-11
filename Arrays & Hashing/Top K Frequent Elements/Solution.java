import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};

        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        // Criar um dict de contagem de ocorrências
        // Criar uma lista de listas que os indices vao de 0 a len(nums) ou seja uma lista com range de len(nums) + 1
        // Inserir nessa lista o numero no indice da quantidade de ocorrencias
        // Percorrer essa lista do final ao comeco e dando append numa lista resposta com os K elementos requeridos e retornar a lista
        HashMap<Integer, Integer> elementOcurrences = new HashMap<>();
        List<List<Integer>> frequencyList = new ArrayList<List<Integer>>();
        //List<Integer> response = new ArrayList<>();
        int[] arrayResponse = new int[k];
        int arrayIndex = 0;

        for (int i = 0; i < nums.length + 1; i++) {
            frequencyList.add(new ArrayList<Integer>());
        }
        
        for (int i : nums) {
            if(!elementOcurrences.containsKey(i)) {
                elementOcurrences.put(i, 1);
                continue;
            }

            elementOcurrences.put(i, elementOcurrences.get(i) + 1);
        }

        for (Integer number : elementOcurrences.keySet()) {
            frequencyList.get(elementOcurrences.get(number)).add(number);
        }

        for (int i = frequencyList.size() - 1; i > 0; i--) {
            for (Integer j : frequencyList.get(i)) {
                arrayResponse[arrayIndex] = j;
                arrayIndex = arrayIndex + 1;
                if(arrayIndex == k) {
                    return arrayResponse;
                }
            }
        }
        return arrayResponse;
    }
}
