<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Document</title>
  </head>
  <body>
    <h1>Insert Book Details into DB</h1>
    <br />
    <form method="post" action="/addBook">
      <label for="bookName">Book Name</label>
      <input type="text" name="bookName" id="bookName" /><br />
      <label for="bookPrice">Book Price</label>
      <input type="text" name="bookPrice" id="bookPrice" />
      <input type="submit" value="Submit" />
    </form>
    <p>${message}</p>
    <a href="/views/home.jsp">Click here to go to homePage</a>
  </body>
</html>
