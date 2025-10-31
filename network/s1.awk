BEGIN {
count=0;
}
{
event=$1;
if(event == "d"){ 
count++; 
}
}
END {
printf("\nnumber of packets dropped is:%d\n",count);
}

