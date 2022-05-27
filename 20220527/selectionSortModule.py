#!/usr/bin/env python
# coding: utf-8

# # selection sort(선택정렬, 교환법) 알고리즘
# 선택 정렬은 i번째 데이터를 선택해서 나머지 데이터(j번째)와 비교하며 정렬한다.  
# 정렬할 데이터가 n개일 경우 회전수는 n-1번이 된다. => 데이터가 5개면 회전수는 4번이다.

# <img src="./selectionSort1.png" width="900" align="left"/>

# <img src="./selectionSort2.png" width="900" align="left"/>

# <img src="./selectionSort3.png" width="900" align="left"/>

# In[4]:


'''
for i in range(4): # 회전수, 데이터 선택 위치
    for j in range(i + 1, 5): # 선택된 위치의 데이터와 비교 대상이 되는 데이터의 위치
        print('[i = {}, j = {}]'.format(i, j), end='')
    print()
'''
pass


# In[16]:


def selectionSortAsc(data):
    for i in range(len(data) - 1):
        for j in range(i + 1, len(data)):
            # print('[i = {}, j = {}]'.format(i, j), end='')
            # 오름차순 정렬 => 앞(i번째)의 데이터가 뒤(j번째)의 데이터보다 크면 두 기억장소의 데이터를 교환한다.
            # 부등호를 '>'에서 '<'로 변경하면 내림차순으로 정렬된다.
            if data[i] > data[j]:
                data[i], data[j] = data[j], data[i]
            # ===== if
        # ===== for j => 회전 종료
        # print('{}회전 결과: {}'.format(i + 1, data))
    # ===== for i => 정렬 종료
    # print('정렬 결과: {}'.format(data))
    return data


# In[17]:


def selectionSortDesc(data):
    for i in range(len(data) - 1):
        for j in range(i + 1, len(data)):
            if data[i] < data[j]:
                data[i], data[j] = data[j], data[i]
    return data


# In[18]:


if __name__ == '__main__':
    data = [8, 3, 4, 9, 1]
    result = selectionSortAsc(data)
    print('오름차순 정렬 결과: {}'.format(result))
    result = selectionSortDesc(data)
    print('내림차순 정렬 결과: {}'.format(result))


# In[ ]:




