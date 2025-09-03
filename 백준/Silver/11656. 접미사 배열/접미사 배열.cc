#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

string arr[1000];

bool compare(string a, string b) {
	return a < b;
}

int main() {
	string str;
	cin >> str;
	int size = str.size();

	for (int i = 0;i < size;i++) {
		arr[i] = str.substr(i, size);
	}

	sort(arr, arr + size, compare);

	for (int i = 0;i < size;i++) {
		cout << arr[i] << endl;
	}

	return 0;
}