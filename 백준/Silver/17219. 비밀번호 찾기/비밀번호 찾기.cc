
#include <iostream>
#include <unordered_map>
#include <string>

using namespace std;

int main(void) {
	int n = 0, m = 0;
	cin >> n >> m;

	unordered_map<string, string> um;
	for (int i = 0;i < n;i++) {
		string site;
		string password;
		cin >> site >> password;
		um[site] = password;
	}

	for (int i = 0;i < m;i++) {
		string find;
		cin >> find;
		cout << um[find] << "\n";
	}

	return 0;
}