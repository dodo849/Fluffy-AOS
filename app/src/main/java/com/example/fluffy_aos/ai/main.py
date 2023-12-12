import json

import pandas as pd
from tensorflow.keras.models import load_model
import numpy as np


def convert_selection(number, max_number):
    selection = [0 for _ in range(0, max_number)]

    selection[max_number - number - 1] = 1

    return selection


columns = ['age', 'weight', 'shoulder-height', 'neck-size', 'back-length', 'chest-size', 'food-amount', 'snack-amount',
           'breed', 'class', 'sex', 'group', 'exercise', 'food-count', 'environment', 'defecation', 'food-kind']

# print("{")
# for column in columns:
#     print("\""+column+"\"" + ": 0,")
# print("}")

column_max_selection_num = {
    'breed': 28,
    'class': 3,
    'sex': 4,
    'group': 7,
    'exercise': 3,
    'food-count': 4,
    'environment': 2,
    'defecation': 2,
    'food-kind': 3
}

# input_data = response['mmselist']
# input_data = [1, 2, 1, 0, 0, 1, 2, 1, 2, 1, 1, 2, 2, 2, 1, 1, 1, 2, 1, 2] # 61개
input_data = [ 1 for _ in range(0, 61)]

# input = input("입력: ")

try:
    # JSON 문자열을 파이썬 객체로 파싱
    json_data = json.loads(input)

    # 파싱된 데이터 출력 또는 활용
    print("파싱된 데이터:", json_data)

except json.JSONDecodeError as e:
    print("JSON 파싱 오류:", e)

input_data = []
for column in columns:
    if column in column_max_selection_num.keys():
        input_data.extend(convert_selection(json_data[column], column_max_selection_num[column]))
    else:
        input_data.append(json_data[column])

print(input_data)

model_df = pd.DataFrame(data=[input_data[0: 61]])

DL_path = './result.h5'
DL_model = load_model(DL_path)
y_pred = DL_model.predict(model_df)
print("dl :", y_pred)
result = y_pred  # 인덱스 0부터 bcs 2~9단계임
bcs_result = np.argmax(result)

print("all result : ", result)
print("bcs result : ", bcs_result + 1)
