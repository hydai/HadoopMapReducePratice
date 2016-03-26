# Do not uncomment these lines to directly execute the script
# Modify the path to fit your need before using this script
#hdfs dfs -rm -r /user/TA/CalculateAverage/Output/
#hadoop jar CalculateAverage.jar calculateAverage.CalculateAverage /user/shared/CalculateAverage/Input /user/TA/CalculateAverage/Output
#hdfs dfs -cat /user/TA/CalculateAverage/Output/part-*

export HADOOP_HOME=/home/cluster33/Disk/hadoop-2.7.2
$HADOOP_HOME/bin/hdfs dfs -rm -r /lab4/CalAvg/output
$HADOOP_HOME/bin/hadoop jar CalculateAverage.jar calculateaverage.CalculateAverage /lab4/CalAvg/input /lab4/CalAvg/output
$HADOOP_HOME/bin/hdfs dfs -cat /lab4/CalAvg/output/part-*
