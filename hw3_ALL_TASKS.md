1.	Rewrite (complete) Driver using “singleton” pattern. Are there any advantages?
Yes, this pattern has itself profits: the one and only one driver for example. But I think it can
became a problem, if we will change some details if testing: make it parallel for the different devises or 
choose DDT paradigm.


2.	Suggest improvements for .properties reading. What are the purposes?
I implement conception of key unification, so now we need not to make variables and fields to store majority
part of values from .properties-files, furthermore we got rid of hardcode in classes. 


3.	Add checks of other fields and their titles (Contact Name, Contact phone) in “native” test
Added.


4.	Optional: Add keyboard presence check  in “native” test.
Now keyboard simulating user typing and adding user info to text fields.


5.	Which checks would you place in the “web” test?
The minimal zone of testing should include checking of the functions with the general priority 
for customer`s business. Something like this:
-The text blocks on html body is visible and contains right correct information;
-The general links on central layout block are available, contains correct title, can be selected && 
chained with correct pages



6.	Implement checks for “web” test in code and try to use.
Checks are implemented;)