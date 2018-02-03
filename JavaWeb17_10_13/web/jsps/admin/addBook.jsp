<%--
  Created by IntelliJ IDEA.
  User: Anakinliu
  Date: 17.12.10
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <form method="post" action="${pageContext.request.contextPath}/admin/CommitBookServlet" class="add_book">
        <fieldset class="add_book">
            <div id="legend" class="">
                <legend class="">Book Detail</legend>
            </div>


            <div class="control-group">

                <!-- Text input-->
                <label class="control-label" for="title">Title</label>
                <div class="controls">
                    <input id="title" name="title" type="text"  class="button button-glow button-border button-rounded button-primary">
                    <p class="help-block"></p>
                </div>
            </div><div class="control-group">

            <!-- Text input-->
            <label class="control-label" for="price">Price</label>
            <div class="controls">
                <input id="price" name="price" type="text"  class="button button-glow button-border button-rounded button-primary">
                <p class="help-block"></p>
            </div>
        </div><div class="control-group">

            <!-- Text input-->
            <label class="control-label" for="isbn">ISBN</label>
            <div class="controls">
                <input id="isbn" name="isbn" type="text"  class="button button-glow button-border button-rounded button-primary">
                <p class="help-block"></p>
            </div>
        </div>

            <div class="control-group">

                <!-- Text input-->
                <label class="control-label" for="pubID">Publisher ID</label>
                <div class="controls">
                    <input id="pubID" name="pubID" type="text"  class="button button-glow button-border button-rounded button-primary">
                    <p class="help-block"></p>
                </div>
            </div>



            <div class="control-group">

                <!-- Text input-->
                <label class="control-label" for="count">Count</label>
                <div class="controls">
                    <input id="count" name="count" type="text"  class="button button-glow button-border button-rounded button-primary">
                    <p class="help-block"></p>
                </div>
            </div>

            <div class="control-group">

                <!-- Textarea -->
                <label class="control-label">Intro</label>
                <div class="controls">
                    <div class="textarea">
                        <label>
                            <textarea id="intro" name="intro" class=""> </textarea>
                        </label>
                    </div>
                </div>
            </div>

        </fieldset>
        <input  id="submit" name="submit" type="submit"
                value="确认"
                class="button button-3d button-royal"/>
    </form>
</div>

