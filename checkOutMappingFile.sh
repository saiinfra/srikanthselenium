#!/bin/sh
if [ ! -d $3 ]
then
   echo "making dir"
   mkdir $3
else
   echo "deleting and making dir"
   rm -rf $3
   mkdir $3
fi
cd $3

git init
git config core.sparseCheckout true
echo $1 > .git/info/sparse-checkout
git remote add -f origin $2
git pull origin master

