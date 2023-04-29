/*

Função para avaliar uma árvore binária matematicamente e retornar um único inteiro resultante.

Todos os nós folha da árvore representam operandos, que sempre serão inteiros positivos.

Todos os outros nós representam operadores. 
Existem 4 operadores suportados, cada um dos quais é representado por um inteiro negativo:
- Operador de adição: adiciona as subárvores esquerda e direita.
- Operador de subtração: subtrai a subárvore direita da subárvore esquerda.
- Operador de multiplicação: multiplica as subárvores esquerda e direita.
- Operador de divisão: divide a subárvore esquerda pela subárvore direita. 
  Se o resultado for decimal, é arredondado em direção a zero.

A árvore precisará ser uma árvore de expressão válida. 

Cada operador também funciona como um símbolo de agrupamento.
O que significa que a parte inferior da árvore é sempre avaliada primeiro, independentemente do operador.

*/

class BinaryTree {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

function evaluateExpressionTree(tree) {
    // Caso base: se o nó for nulo, retorne 0
    if (tree === null) {
        return 0;
    }
    
    // Se o valor do nó for um operando (inteiro positivo), retorne o valor
    if (tree.value > 0) {
        return tree.value;
    }
    
    // Avalia as subárvores esquerda e direita recursivamente
    const left = evaluateExpressionTree(tree.left);
    const right = evaluateExpressionTree(tree.right);
    
    // Avalia o operador atual com base no valor do nó
    switch (tree.value) {
        case -1: // Adição
            return left + right;
        case -2: // Subtração
            return left - right;
        case -3: // Divisão
            return Math.trunc(left / right); // Remove a parte fracionária do resultado
        case -4: // Multiplicação
            return left * right;
        default:
            return -1; // Este caso não deve ocorrer, mas é incluído por precaução
    }
}

exports.BinaryTree = BinaryTree;
exports.evaluateExpressionTree = evaluateExpressionTree;