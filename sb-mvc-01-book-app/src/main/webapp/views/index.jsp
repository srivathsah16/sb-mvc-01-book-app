<!DOCTYPE html>
<html>
  <head>
    <title>Book Application</title>
  </head>
  <body>
    <h1>Book Details</h1>
    <form action="/book">
      Book Id : <input type="text" name="id" />
      <button>Search</button>
    </form>
    <hr />
    Book Id: ${book.id}
    <br />
    Book Name : ${book.name}
    <br />
    Book Price : ${book.price}

    <br />
    <a href="/views/home.jsp">Click here to go to home page</a>
  </body>
</html>
