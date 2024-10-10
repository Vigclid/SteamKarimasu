<aside id="sidebarA">
    <nav>
      <ul>
          <li><a class="current" href="index.jsp">Home</a></li>
          <li><a href="addStudent.jsp"> Student Enrollment</a></li>

          <li>
              <form id="studentListForm" action="StudentServlet" method="POST">
              <a href="#" onclick="submitForm()">Student list</a>
              <input  type="hidden" name= "COMMAND" value="LIST">
              </form>
          </li>

          <li><a href="search.jsp">Student Search</a></li>
      </ul>
    </nav>


    <script>
        function submitForm() {
            document.getElementById("studentListForm").submit();
        }

    </script>
</aside>