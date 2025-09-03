#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main() {
    while (1) {
        string str;
        getline(cin, str);
        if (str == ".") break;  // 종료 조건
        
        stack<char> s;
        bool isValid = true;

        for (int i = 0; i < str.size(); i++) {
            if (str[i] == '(' || str[i] == '[') {
                s.push(str[i]);
            }
            else if (str[i] == ')') {
                if (s.empty() || s.top() != '(') {
                    isValid = false;
                    break;
                }
                s.pop();
            }
            else if (str[i] == ']') {
                if (s.empty() || s.top() != '[') {
                    isValid = false;
                    break;
                }
                s.pop();
            }
        }

        if (isValid && s.empty()) cout << "yes" << endl;
        else cout << "no" << endl;
    }
}
