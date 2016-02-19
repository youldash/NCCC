#include<iostream>
#include<stdio.h>
#include<string.h>
#include<queue>
using namespace std;
int map[105][105];
int num;
struct node
{
    int x,y;
    node(int x=0,int y=0):x(x),y(y){};
};
int bfs(int n,int *s)
{
    queue<int> que;
    int now,next;
    memset(s,0,sizeof(s));
    now=n;
    que.push(now);
    while(!que.empty())
    {
        now=que.front();
        que.pop();
        for(int i=0;i<num;i++)
        {
            next=i;
            if(map[now][i]==1&&s[i]==0&&i!=n)
            {
                s[i]=s[now]+1;
                que.push(next);
            }
        }
    }
}
int main()
{
    int T;
    int A[105],B[105];
    scanf("%d",&T);
    for(int tt=1;tt<=T;tt++)
    {
        int q;
        int a,b;
        int S,E;
        memset(A,0,sizeof(A));
        memset(B,0,sizeof(B));
        memset(map,0,sizeof(map));
        scanf("%d%d",&num,&q);
        for(int i=0;i<q;i++)
        {
            scanf("%d %d",&a,&b);
            map[a][b]=map[b][a]=1;
        }
        scanf("%d%d",&S,&E);
        bfs(S,A);
        bfs(E,B);
        int ans=0;
        for(int i=0;i<num;i++)
        {
            ans=max(A[i]+B[i],ans);
        }
        printf("Case %d: %d\n",tt,ans);
    }
    return 0;
}