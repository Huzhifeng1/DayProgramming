# coding=utf-8
#!usr/bin/env/python
# 把movie.ENTITYSET.txt中的电影名分开电影名和时间存放在数据库表中
import sys
reload(sys)
sys.setdefaultencoding('utf-8')

import re
import mysql.connector
import MySQLdb

movie_name_year = []
movie_name = []
movie_year = []

# 读取txt中的电影名（年份）的函数
def openFile(filename):
    f = open(filename, 'r')
    sourceInLines = f.readlines()  # 按行读出文件内容
    f.close()
    array = []                                   # 定义一个空列表，用来存储结果
    for line in sourceInLines:
        temp1 = line.strip('\n')       # 去掉每行最后的换行符'\n'
        temp2 = temp1.split(',')
        array.append(temp2)        # 将上一步得到的列表添加到new中
    return array

# 读取txt中的电影名（年份）
array = openFile('D:/0508douban/movie.ENTITYSET.txt')

for item in array:
    for temp in item:
        movie_name_year.append(temp)

# 正则表达式分别提取电影名和时间
for item in movie_name_year:
    pattern = re.compile('\((.*?)\)', re.S)
    temp_year = re.findall(pattern, item)
    pattern2 = re.compile('(.*?)\(', re.S)
    temp_name = re.findall(pattern2, item)

    movie_name.append(temp_name)
    movie_year.append(temp_year)

# 用来放存进数据库的数据
data = []

for i in range(len(movie_name)):
    for item in movie_name[i]:
        for item2 in movie_year[i]:
            data.append([item, item2])


# print data

# 连接mysql
db = MySQLdb.connect("localhost", "root", "password", "db_doubanmovie_0508", charset='utf8')
cursor = db.cursor()
sql = """INSERT INTO doubanmovie_entityset(movie_name, movie_year)
         VALUES (%s, %s)"""

try:
   cursor.executemany(sql, data)
   db.commit()
except:
   db.rollback()

db.close()
