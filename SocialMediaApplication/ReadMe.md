Social Media Application

(User and post had one to many relationship)


///user entity
User 
Posts

User -> Posts


/////////////////////

Retrieves all users - 	GET 		/users
Create a User - 		POST 		/users
Retrieve one user - 		GET			/users/{user_id}
Delete user - 			DELETE		/users/{user_id}

Retrieve all post for a user -   GET 	/users/{user_id}/posts
Create Post for a user - 		POST	/users/{user_id}/posts
Retrieve details of a post - 	GET     /users/{user_id}/posts/{post_id}
Delete post 					Delete  /posts/{post_id}


