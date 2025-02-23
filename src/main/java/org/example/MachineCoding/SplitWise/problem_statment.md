https://workat.tech/machine-coding/practice/splitwise-problem-0kp2yneec2q2

Available Commands:
1. ADD_USER <UserName> <UserEmail>
2. CREATE_GROUP <GroupName>
3. ADD_USER_TO_GROUP <GroupName> <UserName>
4. ADD_EXPENSE_IN_GROUP <GroupName> <Payee> <Amount> <NoOfParticipants> <ParticipantNames> <SplitType> <SplitShareIfAny>
4. SHOW_GROUP_STATUS <GroupName>
5. EXIT

Sample Commands:

add_user mahesh mp@gmail.com
add_user pankaj pk@gmail.com
create_group Roommates
add_user_to_group Roommates mahesh
add_user_to_group Roommates pankaj

show_group_status Roommates

add_expense_in_group Roommates mahesh 100 1 pankaj EQUAL

show_group_status Roommates

add_user vinayak vw@gmail.com
add_expense_in_group Roommates vinayak 100 2 mahesh pankaj EQUAL
add_user_to_group Roommates vinayak
add_expense_in_group Roommates vinayak 100 2 mahesh pankaj EQUAL

show_group_status Roommates

add_expense_in_group Roommates vinayak 100 2 mahesh pankaj EXACT 40 60

show_group_status Roommates

add_expense_in_group Roommates pankaj 200 2 mahesh vinayak PERCENTAGE 20 80