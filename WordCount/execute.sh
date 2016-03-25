# Do not uncomment these lines to directly execute the script
# Modify the path to fit your need before using this script
#hdfs dfs -rm -r /user/TA/WordCount/Output/
#hadoop jar WordCount.jar wordcount.WordCount /user/shared/WordCount/Input /user/TA/WordCount/Output
#hdfs dfs -cat /user/TA/WordCount/Output/part-*

export HADOOP_HOME=/home/cluster33/Disk/hadoop-2.7.2
$HADOOP_HOME/bin/hdfs dfs -rm -r /lab4/WordCount/output
$HADOOP_HOME/bin/hadoop jar WordCount.jar wordcount.WordCount /lab4/WordCount/input /lab4/WordCount/output
$HADOOP_HOME/bin/hdfs dfs -cat /lab4/WordCount/output/part-*
