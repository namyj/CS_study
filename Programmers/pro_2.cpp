#include <algorithm>
#include <vector>

using namespace std;

// DESC sort func
bool compare(int a, int b) {
    return a > b;
}

int solution(vector<int> numbers) {
    sort(numbers.begin(), numbers.end(), compare);
    return numbers[0] * numbers[1];
}