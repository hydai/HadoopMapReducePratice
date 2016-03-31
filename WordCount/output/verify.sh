#!/bin/bash

cat part-r-0000* > user.out
diff user.out ans.out
