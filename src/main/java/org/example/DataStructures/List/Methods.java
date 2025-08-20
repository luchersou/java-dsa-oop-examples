package org.example.DataStructures.List;

public class Methods {

/*

# Main methods accessible by all of its implementations:

Implementations:
List<String> linkedList = new LinkedList<>();
List<String> arrayList = new ArrayList<>();
List<String> stack = new Stack<>();
List<String> vector = new Vector<>();



add(E e) – Adds an element to the end.
add(int index, E e) – Inserts an element at a specific index.
get(int index) – Retrieves an element by index.
set(int index, E e) – Replaces an element at a given index.
remove(int index) – Removes an element by index.
remove(Object o) – Removes the first occurrence of an object.
size() – Returns the number of elements.
isEmpty() – Checks if the list is empty.
clear() – Removes all elements.
contains(Object o) – Checks if an element exists.
indexOf(Object o) – Returns the first index of an element.
lastIndexOf(Object o) – Returns the last index of an element.
addAll(Collection<? extends E> c) – Adds all elements from another collection.
addAll(int index, Collection<? extends E> c) – Inserts all elements at a specific index.
removeAll(Collection<?> c) – Removes all elements present in another collection.
retainAll(Collection<?> c) – Keeps only elements present in another collection.
iterator() – Returns an iterator for looping.
listIterator() – Returns a list iterator (supports bidirectional traversal).
toArray() – Converts the list to an array.
subList(int fromIndex, int toIndex) – Returns a sublist.

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListMethodsExample {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        
        // ===== MÉTODOS DE ADIÇÃO =====
        System.out.println("=== MÉTODOS DE ADIÇÃO ===");
        lista.add("Java");                    // Adiciona no final
        lista.add("Python");
        lista.add("JavaScript");
        lista.add(1, "C++");                  // Adiciona na posição 1
        System.out.println("Após adições: " + lista);
        
        List<String> outraLista = Arrays.asList("Go", "Rust");
        lista.addAll(outraLista);             // Adiciona coleção no final
        lista.addAll(2, Arrays.asList("C#", "Swift")); // Adiciona coleção na posição 2
        System.out.println("Após addAll: " + lista);
        
        // ===== MÉTODOS DE ACESSO =====
        System.out.println("\n=== MÉTODOS DE ACESSO ===");
        System.out.println("Elemento na posição 0: " + lista.get(0));
        System.out.println("Tamanho da lista: " + lista.size());
        System.out.println("Lista vazia? " + lista.isEmpty());
        System.out.println("Contém 'Java'? " + lista.contains("Java"));
        System.out.println("Contém todos de outraLista? " + lista.containsAll(outraLista));
        
        // ===== MÉTODOS DE BUSCA =====
        System.out.println("\n=== MÉTODOS DE BUSCA ===");
        System.out.println("Primeiro índice de 'Java': " + lista.indexOf("Java"));
        System.out.println("Último índice de 'Java': " + lista.lastIndexOf("Java"));
        System.out.println("Índice de 'Kotlin' (não existe): " + lista.indexOf("Kotlin"));
        
        // ===== MÉTODOS DE MODIFICAÇÃO =====
        System.out.println("\n=== MÉTODOS DE MODIFICAÇÃO ===");
        String elementoSubstituido = lista.set(0, "Kotlin"); // Substitui elemento na posição 0
        System.out.println("Elemento substituído: " + elementoSubstituido);
        System.out.println("Lista após substituição: " + lista);
        
        // ===== MÉTODOS DE REMOÇÃO =====
        System.out.println("\n=== MÉTODOS DE REMOÇÃO ===");
        String removidoPorIndice = lista.remove(1);      // Remove por índice
        System.out.println("Removido por índice 1: " + removidoPorIndice);
        
        boolean removidoPorValor = lista.remove("Swift"); // Remove por valor
        System.out.println("'Swift' removido? " + removidoPorValor);
        System.out.println("Lista após remoções: " + lista);
        
        // ===== SUBLISTA =====
        System.out.println("\n=== SUBLISTA ===");
        List<String> sublista = lista.subList(1, 4); // Elementos do índice 1 ao 3
        System.out.println("Sublista (1-3): " + sublista);
        
        // ===== CONVERSÃO PARA ARRAY =====
        System.out.println("\n=== CONVERSÃO PARA ARRAY ===");
        Object[] array = lista.toArray();
        System.out.println("Array de Object: " + Arrays.toString(array));
        
        String[] stringArray = lista.toArray(new String[0]);
        System.out.println("Array de String: " + Arrays.toString(stringArray));
        
        // ===== ITERAÇÃO =====
        System.out.println("\n=== ITERAÇÃO ===");
        
        // Iterator simples
        System.out.println("Com Iterator:");
        Iterator<String> it = lista.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        
        // ListIterator (bidirecional)
        System.out.println("Com ListIterator (reverso):");
        ListIterator<String> listIt = lista.listIterator(lista.size());
        while (listIt.hasPrevious()) {
            System.out.print(listIt.previous() + " ");
        }
        System.out.println();
        
        // Enhanced for loop
        System.out.println("Com enhanced for:");
        for (String linguagem : lista) {
            System.out.print(linguagem + " ");
        }
        System.out.println();
        
        // ===== MÉTODOS JAVA 8+ =====
        System.out.println("\n=== MÉTODOS JAVA 8+ ===");
        
        // forEach com Consumer
        System.out.println("Com forEach:");
        lista.forEach(linguagem -> System.out.print(linguagem.toUpperCase() + " "));
        System.out.println();
        
        // removeIf com Predicate
        List<String> listaParaRemover = new ArrayList<>(lista);
        boolean removeuAlgum = listaParaRemover.removeIf(s -> s.length() < 4);
        System.out.println("Removeu elementos com menos de 4 chars? " + removeuAlgum);
        System.out.println("Lista após removeIf: " + listaParaRemover);
        
        // replaceAll com UnaryOperator
        List<String> listaParaSubstituir = new ArrayList<>(lista);
        listaParaSubstituir.replaceAll(String::toLowerCase);
        System.out.println("Lista após replaceAll (toLowerCase): " + listaParaSubstituir);
        
        // sort com Comparator
        List<String> listaParaOrdenar = new ArrayList<>(lista);
        listaParaOrdenar.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println("Lista ordenada: " + listaParaOrdenar);
        
        // Stream operations
        System.out.println("Linguagens que começam com 'J':");
        lista.stream()
             .filter(s -> s.startsWith("J"))
             .forEach(System.out::println);
        
        // ===== OPERAÇÕES DE CONJUNTO =====
        System.out.println("\n=== OPERAÇÕES DE CONJUNTO ===");
        List<String> lista1 = new ArrayList<>(Arrays.asList("Java", "Python", "C++"));
        List<String> lista2 = new ArrayList<>(Arrays.asList("Python", "JavaScript", "Go"));
        
        // retainAll (interseção)
        List<String> intersecao = new ArrayList<>(lista1);
        intersecao.retainAll(lista2);
        System.out.println("Interseção: " + intersecao);
        
        // removeAll (diferença)
        List<String> diferenca = new ArrayList<>(lista1);
        diferenca.removeAll(lista2);
        System.out.println("Diferença (lista1 - lista2): " + diferenca);
        
        // ===== MÉTODOS ESPECIAIS DO LISTITERATOR =====
        System.out.println("\n=== MÉTODOS ESPECIAIS DO LISTITERATOR ===");
        ListIterator<String> specialIt = lista.listIterator();
        
        if (specialIt.hasNext()) {
            System.out.println("Próximo elemento: " + specialIt.next());
            System.out.println("Índice atual: " + specialIt.nextIndex());
            System.out.println("Índice anterior: " + specialIt.previousIndex());
            
            // Modificação durante iteração
            specialIt.set("MODIFICADO"); // Substitui o elemento atual
            specialIt.add("NOVO");       // Adiciona novo elemento
        }
        System.out.println("Lista após modificações com ListIterator: " + lista);
        
        // ===== LIMPEZA =====
        System.out.println("\n=== LIMPEZA ===");
        List<String> listaParaLimpar = new ArrayList<>(lista);
        listaParaLimpar.clear();
        System.out.println("Lista após clear(): " + listaParaLimpar);
        System.out.println("Está vazia? " + listaParaLimpar.isEmpty());
    }
}

*/
}
