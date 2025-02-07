def solution(name, yearning, photo):
    score_dict = dict(zip(name, yearning))
    answer = []
    for p in photo:
        sum = 0
        for person in p:
            sum += score_dict.get(person, 0)
        answer.append(sum)
    return answer