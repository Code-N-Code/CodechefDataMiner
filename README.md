# CodechefDatainer
A java web scraping project to fetch user data from user id from codechef.com

---

#### CodechefDataManager
This is the main class which contains all of the functionalities


### List of functions and their short description

- void setUserId(String userId)
  - Used to set the userId of the user for which we want to fetch details
- int getUserCurrentRating()
  - This function returns current rating of the user
- String getUserName()
  - returns Name of the user
- List<String> getSolvedProblems()
  - returns list of problems (problem codes) solved (completely) by user
- int partialSolvedCount()
  - returns list of problems (problem codes) solved (partially) by user
- int partialSolvedCount()
  - returns number of problems solved (partially) by user
- int fullySolvedCount()
  - returns number of problems solved (completely) by user
