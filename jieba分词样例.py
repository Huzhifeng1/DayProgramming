# coding=utf-8
#!usr/bin/env/python
# 用结巴分词包对语料分词
import sys
reload(sys)
sys.setdefaultencoding('utf-8')
import jieba

seg_list = jieba.cut('我来到北京清华大学', cut_all=True)
print "Full Mode:", "/ ".join(seg_list)  # 全模式

seg_list2 = jieba.cut("我来到北京清华大学", cut_all=False)
print "Default Mode:", "/ ".join(seg_list2)  # 精确模式

seg_list3 = jieba.cut("他来到了网易杭研大厦")  # 默认是精确模式
print ", ".join(seg_list3)

seg_list4 = jieba.cut_for_search("小明硕士毕业于中国科学院计算所，后在日本京都大学深造")  # 搜索引擎模式
print ", ".join(seg_list4)



