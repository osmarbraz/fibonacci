/*
 * Universidade Federal de Santa Catarina - UFSC
 * Departamento de Informática e Estatística - INE
 * Programa de Pós-Graduação em Ciências da Computação - PROPG
 * Disciplinas: Projeto e Análise de Algoritmos
 * Prof Alexandre Gonçalves da Silva 
 * Baseado nos slides 7 da aula do dia 03/11/2017 
 */

/**
 *
 * @author Osmar de Oliveira Braz Junior
 */
public class Principal {

    /**
     * Fibonacci recursivo
     *
     * @param n Quantidade de termos a ser calculada
     * @return O termo da posição
     */
    public static int fibonacciRecursivo(int n) {
        if (n <= 1) {
            return n;
        } else {
            int a = fibonacciRecursivo(n - 1);
            int b = fibonacciRecursivo(n - 2);
            return (a + b);
        }
    }

    /**
     * Fibonaci com programação dinâmica. Com tabela para armazenar resultados
     *
     * @param n Quantidade de termos a ser calculada
     * @return O termo da posição
     */
    public static int fibonacci(int n) {
        int f[] = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    /**
     * Fibonaci com programação dinâmica. Com economia de espaço
     *
     * @param n Quantidade de termos a ser calculada
     * @return O termo da posição
     */
    public static int fibonacci1(int n) {
        if (n == 0) {
            return 0;
        } else {
            int f_ant = 0;
            int f_atual = 1;
            for (int i = 2; i <= n; i++) {
                int f_prox = f_atual + f_ant;
                f_ant = f_atual;
                f_atual = f_prox;
            }
            return f_atual;
        }
    }

    /**
     * Fibonaci com programação dinâmica. Versão recursiva eficiente. Não
     * recalcula os valores de f
     *
     * @param n Quantidade de termos a ser calculada
     * @return O termo da posição
     */
    public static int memoizeFibo(int n) {
        int f[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            f[i] = -1;
        }
        return lookupFibo(f, n - 1);
    }

    /**
     * Fibonaci com programação dinâmica. Versão recursiva eficiente. Não
     * recalcula os valores de f
     *
     * @param f Tabela dos valores
     * @param n Quantidade de termos a ser calculada
     * @return O termo da posição
     */
    public static int lookupFibo(int f[], int n) {
        if (f[n] >= 0) {
            return f[n];
        } else {
            if (n <= 1) {
                f[n] = 1;
            } else {
                f[n] = lookupFibo(f, n - 1) + lookupFibo(f, n - 2);
            }
            return f[n];
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Fibonacci Recursivo:" + fibonacciRecursivo(5));
        System.out.println("Fibonacci dinânico com tabela:" + fibonacci(5));
        System.out.println("Fibonacci dinânico com economia:" + fibonacci1(5));
        System.out.println("Fibonacci dinâmico recursivo:" + memoizeFibo(5));
    }

}
