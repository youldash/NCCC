#include <iostream>
using namespace std;
#define MaxSize 100
#define INF 32767

void Floyd(int roads[][MaxSize],int dist[][MaxSize],int n)
{
	int i,j,k;
	for (i=0;i<n;i++)
	{
		for (j=0;j<n;j++)
		{
			dist[i][j]=roads[i][j];
		}
	}
	for (k=0;k<n;k++)
	{
		for (i=0;i<n;i++)
		{
			for (j=0;j<n;j++)
			{
				if (dist[i][j]>dist[i][k]+dist[k][j])
				{
					dist[i][j]=dist[i][k]+dist[k][j];
				}
			}
		}
	}
}
int main()
{
	int T,N,R,s,d,a,b,i,j,k,min;
	int roads[MaxSize][MaxSize];
	int dist[MaxSize][MaxSize];
	cin>>T;
	for (k=0;k<T;k++)
	{
		memset(roads,INF,sizeof(roads));
		memset(dist,INF,sizeof(dist));
		cin>>N>>R;
		for (i=0;i<N;i++)
		{
			for (j=0;j<N;j++)
			{
				roads[i][j]=INF;
				if (i==j)
				{
					roads[i][j]=0;
				}
			}
		}
		while (R--)
		{
			cin>>a>>b;
			roads[a][b]=1;
			roads[b][a]=1;
		}
		Floyd(roads,dist,N);
		cin>>s>>d;
		min=0;
		for (i=0;i<N;i++)
		{
			if (dist[s][i]+dist[i][d]>min)
			{
				min=dist[s][i]+dist[i][d];
			}
		}
		cout<<"Case "<<k+1<<": "<<min<<endl;
	}
	return 0;
}