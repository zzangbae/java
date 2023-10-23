// MST, Spanning Tree -> Minimum Spanning Tree
// MST 알고리즘 중 하나 -> 크루스칼 알고리즘
// 가중치 그래프에서, 가중치의 합을 최소로 하는 Spanning Tree
// -> 가중치가 작은 간선부터 고르는 것
// -> 만약, 같은 가중치의 간선이 여러 개인 경우, 아무거나 고른다.
// 단, 트리이기 때문에 사이클이 생기면 안된다.
// 어떻게 사이클이 발생하지 않도록 할까? -> Union-Find
// : 특정 간선을 선택하면, 두 노드에 union연산을 수행
// 만약 사이클이 발생하면, 이미 두 노드는 같은 집합에 속한 상태 
// -> 미리 체크하여 같은 집합이라면 합치지 않고 넘어감
public class Prac1 {
    public static void main(String[] args) {
        
    }
}
// function kruskal()
//     mst = []                       // mst를 담을 배열입니다.
//     sort edge[] by length          // 간선을 가중치 기준으로 오름차순 정렬합니다.
//     uf = uf_init(|V|)              // uf 배열을 노드의 수 |V|만큼 초기화합니다.

//     for E in edge[]                // 각각의 간선에 대해 
//         u, v = E                   // 간선을 이루고 있는 두 노드 u, v를 보며
//         if find(u) != find(v)      // u, v의 루트 노드가 다른 경우에만
//             mst.push(E)            // mst에 해당 간선을 넣어주고
//             union(u, v)            // u, v를 같은 루트 노드를 갖도록 만들어줍니다.
    
//     return mst

