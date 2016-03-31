# Do not uncomment these lines to directly execute the script
# Modify the path to fit your need before using this script
#hdfs dfs -rm -r /user/TA/WordCount/Output/
#hadoop jar WordCount.jar wordcount.WordCount /user/shared/WordCount/Input /user/TA/WordCount/Output
#hdfs dfs -cat /user/TA/WordCount/Output/part-*

$HADOOP_HOME/bin/hdfs dfs -rm -r WordCount/output
$HADOOP_HOME/bin/hadoop jar WordCount.jar wordcount.WordCount WordCount/input WordCount/output
$HADOOP_HOME/bin/hdfs dfs -cat WordCount/output/part-*
