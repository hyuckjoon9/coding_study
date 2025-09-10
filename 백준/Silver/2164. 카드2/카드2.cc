#include <iostream>
#include <queue>

using namespace std;

int main(void) {
	int n = 0;
	cin >> n;

	queue<int> q;
	for (int i = 1;i <= n;i++) {
		q.push(i);
	}

	while (q.size() > 1) {
		q.pop();		 

		if (q.size() > 1) {
			int frontElement = q.front();
			q.pop();
			q.push(frontElement);
		}
	}
	if(!q.empty()) cout << q.front();

	return 0;
}