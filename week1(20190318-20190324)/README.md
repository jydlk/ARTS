#  Algorithm

## 1、题目描述

给定一个只包括 `'('`，`')'`，`'{'`，`'}'`，`'['`，`']'` 的字符串，判断字符串是否有效。

有效字符串需满足：

1. 左括号必须用相同类型的右括号闭合。
2. 左括号必须以正确的顺序闭合。

注意空字符串可被认为是有效字符串。

**示例 1:**

```
输入: "()"
输出: true
```

**示例 2:**

```
输入: "()[]{}"
输出: true
```

**示例 3:**

```
输入: "(]"
输出: false
```

**示例 4:**

```
输入: "([)]"
输出: false
```

**示例 5:**

```
输入: "{[]}"
输出: true
```

## 2、解题历程

### 1、为什么选择这个题目?

其实在leetcode做算法题，主要目的还是锻炼自己的思维，学习一些与数据结构有关的只是，也选择一些与自己实际开发中用到的一些知识相结合，所以第一次选择与“栈”有关的题目，当然了，由难到易，出于对自己实力的考虑，选择从最简单的题目开始。

虽然该题目在leetcode上的难易程度是“简单”，但是拿到题目的第一感觉是懵逼的，好长时间没有做过数据结构算法相关的题目了，不知道如何下手，没有一点思路。第一天就放弃了，隔一天后才重新审题，考虑解题方法。盯着题目还是没有思路，只能一行一行的读。其实题目已经很清楚了，有效字符满足两个条件，第一个就是“左括号必须用相同类型的右括号闭合”，当时想第一个条件咋实现呢？ 其实满足第一个条件很简单，一种方法就是遍历该字符串，用计数器count1,count2,count3分别记录下“(",“{”，“[”的个数，用count4,count5,count6分别记录下“)”，“}”，“]”，的个数，判断count1==count4，count2==count5，count3==count6是否相等即可。但是第二个条件却想不出好的方法解决。后来想到既然题目是有关“栈”的问题，能否用java中的栈来解决呢，后来想完全是可以的，并且在满足第二个条件的同时，第一个条件也迎刃而解。

### 2、思路：

  使用java中的Stack类实现，栈：后进先出(last-in-first-out)

  字符串转换为字符数组，遍历该字符数组，如果是“(",“{”，“[”，则直接入栈， 如果是“)”，“}”，“]”，则从栈顶弹出元素，判断是否匹配，循环结束，如果栈不为空，则是无效的，

   代码详见Solution.java

运行结果：

![](D:\Git\ARTS\week1(20190318-20190324)\result.png)

内存消耗太高，好尴尬。

### 3、感悟：

从一开始的毫无思路，到顺利把题目完成，自己终于迈出了坚实的一步，其实只要肯努力下公司，是肯定可以完成的。通过做这个小题目，暴露了自己java基础知识不牢固的缺点，之前开发都是通过idea，有提示，这个题目直接在网页上敲代码，没有提示，String类的一些常用方法竟然记不起来，还有引用泛型，竟然引用了基本类型，真是有够差劲，所以以后夯实基础尤为重要。