import data.Comment
import data.Post
import data.User
import resources.Data

/**
# Fueled Kotlin Exercise
A blogging platform stores the following information that is available through separate API endpoints:
+ user accounts
+ blog posts for each user
+ comments for each blog post
### Objective
The organization needs to identify the 3 most engaging bloggers on the platform. Using only Kotlin and the Kotlin standard library, output the top 3 users with the highest average number of comments per post in the following format:
`[name]` - `[id]`, Score: `[average_comments]`
Instead of connecting to a remote API, we are providing this data in form of JSON files, which have been made accessible through a custom Resource enum with a `data` method that provides the contents of the file.
### What we're looking to evaluate
1. How you choose to model your data
2. How you transform the provided JSON data to your data model
3. How you use your models to calculate this average value
4. How you use this data point to sort the users
 */


fun main(vararg args: String) {

    //variables to hold the list of data from json files
    val commentList = Data.getComments<List<Comment>>()
    val userList = Data.getUsers<List<User>>()
    val postList = Data.getPosts<List<Post>>()

    //define hash map to hold comment for every post
    val commentNumber: HashMap<Int, Int> = HashMap()

    for (comments in commentList) {
        val postId = comments.postId
        if (commentNumber.containsKey(postId)) {
            commentNumber[postId] = commentNumber[postId]?.plus(1) ?: 0
        } else {
            commentNumber[postId] = 1
        }
    }

    //define variables for users average calculation process
    var commentSum: Float = 0f
    var commentPerUser: Float = 0f
    //hash map to hold user average
    val userAverage: HashMap<Int, Array<Float>> = HashMap()

    for (posts in postList) {
        val userId = posts.userId
        val postId = posts.id
        if (userAverage.containsKey(userId)) {
            commentSum = userAverage[userId]?.get(0)!!
            commentPerUser = userAverage[userId]?.get(1)!!
            val number = commentNumber[postId]
            number?.let { commentSum += number }
            commentPerUser += 1
            userAverage[userId] = arrayOf(commentSum, commentPerUser)
        } else {
            val number = commentNumber[postId]
            commentSum = number?.toFloat()!!
            commentPerUser = 1f
            userAverage[userId] = arrayOf(commentSum, commentPerUser)
        }
    }

    //iterate through users to find average of each user with its id and name
    for(users in userAverage.keys){
        commentSum= userAverage[users]?.get(0)!!
        commentPerUser=userAverage[users]?.get(1)!!
        val average:Float=commentSum/commentPerUser
        System.out.println("user id= "+users+ " average= "+average+"name= "+userList[users-1].name)
    }

}