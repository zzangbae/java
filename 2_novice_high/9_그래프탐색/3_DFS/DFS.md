# DFS

* 스택
* 깊이 우선 탐색
* 재귀
* visited 함수 이용
* 수도 코드
    ```
        function dfs(pos)
            visit(pos)
            for children of pos
                if(visited[child] == false)
                    dfs(child)
    ```