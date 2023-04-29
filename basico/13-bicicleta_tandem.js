/*

Uma bicicleta tandem é uma bicicleta operada por duas pessoas: pessoa A e pessoa B. 
Ambas as pessoas pedalam a bicicleta, mas a pessoa que pedala mais rápido determina a velocidade da bicicleta. 

Então, se a pessoa A pedala em velocidade 5 e a pessoa B pedala em velocidade 4, 
a bicicleta tandem se move a uma velocidade 5 (tandemSpeed = max(speedA, speedB).

Input: duas listas de números inteiros positivos:
    - uma que contém as velocidades dos ciclistas usando camisas vermelhas
    - outra que contém as velocidades dos ciclistas usando camisas azuis. 
    
Cada ciclista é representado por um único número inteiro positivo, que é a velocidade com que pedalam uma bicicleta tandem. 
Ambas as listas têm o mesmo comprimento, o que significa que há tantos ciclistas de camisas vermelhas quanto ciclistas de camisas azuis. 

O objetivo aqui é formar pares: um ciclista usando camisa vermelha com outro usando camisa azul para operar a bicicleta.

Essa função retorna a velocidade total máxima possível ou a velocidade total mínima possível de todas as bicicletas tandem sendo pedaladas com base no parâmetro de entrada fastest. 

Se fastest = true, a função retorna a velocidade total máxima possível; 
caso contrário, retorna a velocidade total mínima.

Velocidade total (totalSpeed) é definido como a soma das velocidades de todas as bicicletas tandem sendo pedaladas. 
Por exemplo, se houver 4 ciclistas (2 ciclistas de camisa vermelha e 2 ciclistas de camisa azul) com velocidades de 1, 3, 4, 5;
e se estiverem emparelhados em bicicletas tandem da seguinte forma: [1, 4], [5, 3];
então a velocidade total dessas bicicletas tandem é 4 + 5 = 9.

*/

function tandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest) {
    // Ordena ambas as listas
    redShirtSpeeds.sort((a, b) => a - b);
    blueShirtSpeeds.sort((a, b) => a - b);
  
    if (fastest) {
      // Inverte a ordem da lista blueShirtSpeeds para obter a velocidade total máxima
      blueShirtSpeeds.reverse();
    }
  
    let totalSpeed = 0;
  
    // Para cada ciclista de camisa vermelha, encontre o par de camisa azul e some a velocidade
    for (let i = 0; i < redShirtSpeeds.length; i++) {
      totalSpeed += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
    }
  
    return totalSpeed;
}

exports.tandemBicycle = tandemBicycle;  