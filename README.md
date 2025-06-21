# 🎓 Engineering Study Application
 

![SpringBoot](https://img.shields.io/badge/SpringBoot-2.7-green)  
![MySQL](https://img.shields.io/badge/MySQL-Database-blue)  
![JPA](https://img.shields.io/badge/JPA-Hibernate-orange)  
![GitHub](https://img.shields.io/badge/GitHub-VersionControl-black)  
![Postman](https://img.shields.io/badge/Postman-API%20Testing-orange)  

 

## 🚀 The Problem Statement and solution

As an engineering student, I often found it difficult to access the right academic resources at the right time. Whether it was hunting for previous year question papers, eBooks, or even important announcements like exam timetables and circulars., we often waste valuable time searching for the study materials we need—whether it's old question papers, class notes, lab manuals, or even basic information like exam timetables. Everything felt scattered and disorganized—spread across group chats, shared drives, and forwarded messages. This constant searching wastes time and adds unnecessary stress, especially during exams and submission deadlines. 

That’s why I developed the Engineering Study Application—to make it easier for students to access academic resources without the hassle. It’s designed to bring everything we need into one organized platform, so we no longer have to depend on others or scroll endlessly through group chats just to find a single file. Through the app, users can upload important resources like notes, lab manuals, and assignments, which are then made accessible to others—encouraging a shared and collaborative academic environment.

To keep the content useful and up to date, users can also remove any outdated or incorrect documents they’ve previously uploaded. The app includes a dedicated section for academic announcements, where students can instantly view important updates like exam timetables, circulars and helping us stay informed at all times.




---

## 📊 Entity Overview



### 📂 _**Users**_
- **ID** 
- **Name** 
- **Email**
- **Password** 
- **Role** - Either `USER` or `ADMIN`  
- **Documents** - List of documents uploaded by the user

### 📄 _**Documents**_
- **ID** 
- **Title** 
- **DocumentType**
- **Branch** 
- **Semester** 
- **AcademicYear** 
- **Department** 
- **FilePath** - file location 
- **User** - User who uploaded the document

### 📢 _**Announcements**_
- **ID** - Unique identifier  
- **Title** - Announcement title  
- **Message** - Announcement content  
- **PostedBy** - User ID who posted it
- 
---

## 🧑‍💻 User Roles

The system supports two main user roles:

### ✅ Admin:
- Admin manages users.
- Admin can create new announcements such as circulars, timetables, re-exam notices and each announcement is automatically deleted after some time.       
- Admin can upload documents such as the syllabus, result pdf, timetables, and ebooks.
- Admin can remove previously uploaded documents that are outdated or incorrect.    

### ✅ User:
- Users can create, update, and delete their profiles
- Users can view announcements related to exam timetables and circulars.
- Users can upload notes, lab manuals and assignments.
- Users can remove previously uploaded documents that are outdated or incorrect.
- Users can convert CGPA into a percentage.
 

---

## 📌 Main Modules

- **Auth Module** – User registration and login  
- **User Management** – Admin creates and manages users  
- **Announcement Module** – Admins post and manage announcements  
- **Document Module** – Students upload and manage study materials  
- **Utility Module** – CGPA conversion tool  

---

  ## 🛠 Technologies Used

- **Backend:** Spring Boot,  Hibernate, JPA  
- **Database:** MySQL  
- **Security:** JWT-based authentication, role-based access control  
- **Build Tool:** Maven  
- **Version Control:**  Git & GitHub

---



## 🔐 Security Features

- JWT-based token authentication  
- Role-based access control (**ADMIN / USER**)  
- Secure password storage using hashing (e.g., BCrypt)  
- Stateless session management  

## 📡 API Endpoints

### 1️⃣ _**Register User**_  
- **📌 Endpoint:** `POST /engineeringstudy/auth/register`  
- **🛠️ Functionality:** Accepts user details and registers a normal user.  
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
![Register User](https://github.com/rutikbodke333/movie-review-system/blob/main/Returns%20a%20list%20of%20movies%20along%20with%20their%20reviews.png?raw=true)

---

### 2️⃣ _**Create User Profile (Admin)**_  
- **📌 Endpoint:** `POST /engineeringstudy/admin/users`  
- **🛠️ Functionality:** Allows admin to create user accounts with admin role.  
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
![Create User Admin](https://github.com/rutikbodke333/movie-review-system/blob/main/Returns%20a%20list%20of%20movies%20along%20with%20their%20reviews.png?raw=true)

---

### 3️⃣ _**Create Announcement (Admin)**_  
- **📌 Endpoint:** `POST /engineeringstudy/admin/announcements`  
- **🛠️ Functionality:** Admin can post a new announcement.  
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
![Create Announcement](https://github.com/rutikbodke333/movie-review-system/blob/main/Returns%20a%20list%20of%20movies%20along%20with%20their%20reviews.png?raw=true)

---

### 4️⃣ _**Get All Announcements**_  
- **📌 Endpoint:** `GET /engineeringstudy/announcements`  
- **🛠️ Functionality:** Returns all announcements visible to users.  
- **🧪 Tested with:** Postman
- **🖼️ Screenshot:**  
![Get All Announcements**](https://github.com/rutikbodke333/movie-review-system/blob/main/Returns%20a%20list%20of%20movies%20along%20with%20their%20reviews.png?raw=true)

---

### 5️⃣ _**Upload PDF (User)**_  
- **📌 Endpoint:** `POST /engineeringstudy/user/documents`  
- **🛠️ Functionality:** Allows a user to upload a study document.  
- **🧪 Tested with:** Postman
- **🖼️ Screenshot:**  
![Upload PDF](https://github.com/rutikbodke333/movie-review-system/blob/main/Returns%20a%20list%20of%20movies%20along%20with%20their%20reviews.png?raw=true)

---

### 6️⃣ _**Convert Percentage to CGPA (User)**_  
- **📌 Endpoint:** `GET /engineeringstudy/user/convert?percentage=85`  
- **🛠️ Functionality:** Returns CGPA equivalent of given percentage.  
- **🧪 Tested with:** Postman
- **🖼️ Screenshot:**  
![Convert Percentage to CGPA](https://github.com/rutikbodke333/movie-review-system/blob/main/Returns%20a%20list%20of%20movies%20along%20with%20their%20reviews.png?raw=true)

---



