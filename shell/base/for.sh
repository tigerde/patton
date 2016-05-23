#!/bin/bash
#moon=""
for i in `ls /etc`
do 
moon=$moon:$i
done 
echo $moon


myarray=(1 2 3 4)
echo "${myarray[*]}"
echo "${myarray[@]}"
for a in "${myarray[@]}";do 
echo $a
done

echo $$
