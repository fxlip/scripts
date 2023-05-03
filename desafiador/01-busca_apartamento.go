/*

Input: lista de blocos em uma rua onde cada bloco contém um possível apartamento para se mudar.

Requisitos: escola/comércio/lazer próximos
Por exemplo, pode ser vantajoso ter uma escola e uma academia perto do apartamento. 

O input recebido contém informações de todos os blocos sobre todos os prédios presentes e ausentes.
Por exemplo, para cada bloco, é possível saber se uma escola, uma piscina, um escritório e uma academia estão presentes.

Nesse algorítmo desejamos escolher um bloco de apartamentos de tal forma que minimize a distância que teriamos que caminhar
do apartamento para alcançar qualquer um dos prédios necessários.

Essa função recebe uma lista de blocos em uma rua específica e uma lista de prédios necessários, retornando a localização (índice) do bloco que é mais otimizado.

Se houver mais de um bloco otimizado, a função retorna o índice de qualquer um deles.

*/

package main

import "math"

type Block map[string]bool

func ApartmentHunting(blocks []Block, reqs []string) int {
    minDistances := make([][]int, len(blocks))

    for i := range blocks {
        minDistances[i] = make([]int, len(reqs))
        for j := range reqs {
            minDistances[i][j] = math.MaxInt32
        }
    }

    for i := range blocks {
        for j, req := range reqs {
            closestReqDistance := math.MaxInt32
            for k, otherBlock := range blocks {
                if otherBlock[req] {
                    closestReqDistance = min(closestReqDistance, abs(i-k))
                }
            }
            minDistances[i][j] = closestReqDistance
        }
    }

    maxDistancesAtBlocks := make([]int, len(blocks))
    for i := range maxDistancesAtBlocks {
        maxDistancesAtBlocks[i] = math.MinInt32
    }

    for i := range blocks {
        for j := range reqs {
            maxDistancesAtBlocks[i] = max(maxDistancesAtBlocks[i], minDistances[i][j])
        }
    }

    return getIdxAtMinValue(maxDistancesAtBlocks)
}

func getIdxAtMinValue(array []int) int {
    idxAtMinValue := 0
    minValue := math.MaxInt32
    for i, value := range array {
        if value < minValue {
            minValue = value
            idxAtMinValue = i
        }
    }
    return idxAtMinValue
}

func abs(a int) int {
    if a < 0 {
        return -a
    }
    return a
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}