### Project Description
The e-commerce application is a full-stack platform designed to facilitate seamless online shopping experiences. Users can browse and purchase products after logging into their accounts. The application incorporates robust backend functionality using Spring Boot and PostgreSQL, ensuring data integrity and performance. The frontend, built with HTML, CSS, and JavaScript, offers an intuitive and user-friendly interface. Admins can manage the entire platform through a dedicated admin view, where they can handle users, products, and orders, ensuring streamlined operations. Additionally, a feedback mechanism enables users to report issues or file complaints effortlessly.

### Entities and Their Permitted Actions

1. **User**:
    - Can register and log in to access the application.
    - Can browse, view, and purchase products.
    - Can file complaints or provide feedback through the messaging system.

2. **Admin**:
    - Can log in to access a dedicated admin view.
    - Can view, add, edit, and delete products in the catalog.
    - Can view, edit, or remove user and admin accounts.
    - Can monitor and manage all orders placed by users.
    - Can review user feedback and address complaints.

3. **Products**:
    - Accessible to users for browsing and purchasing.
    - Modifiable by admins for updates in product details, addition of new items, or deletion of outdated entries.

4. **Orders**:
    - Created when users place orders for products.
    - Visible to admins for tracking and processing.

5. **Messages (User Feedback)**:
    - Generated by users to report issues or share concerns.
    - Accessible to admins for review and resolution.

### Tech Stack

- **Frontend**: HTML, CSS, JavaScript for designing and developing a dynamic and responsive user interface.
- **Backend**: Spring Boot for implementing robust server-side logic and business workflows.
- **Database**: PostgreSQL for secure and efficient data storage and retrieval, supporting complex relationships among entities.
- **ORM**: Spring Data JPA for java based communication with the database.  
