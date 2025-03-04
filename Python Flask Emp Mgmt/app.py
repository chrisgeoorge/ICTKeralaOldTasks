from flask import Flask, render_template, request, redirect, url_for, jsonify
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///employees.db'
db = SQLAlchemy(app)

class Employee(db.Model):
    employee_id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(100), nullable=False)
    department = db.Column(db.String(100), nullable=False)
    
    def display_employee(self):
        return f"ID: {self.employee_id}, Name: {self.name}, Department: {self.department}"

@app.before_request
def create_tables():
    db.create_all()

@app.route('/')
def home():
    return "Welcome to Employee Management System"

@app.route('/add_employee', methods=['GET', 'POST'])
def add_employee():
    if request.method == 'POST':
        try:
            employee_id = int(request.form['employee_id'])
            name = request.form['name']
            department = request.form['department']
            
            if Employee.query.get(employee_id):
                return jsonify({"error": "Employee ID already exists"}), 400
            
            emp = Employee(employee_id=employee_id, name=name, department=department)
            db.session.add(emp)
            db.session.commit()
            return jsonify({"message": "Employee added successfully", "employee": emp.display_employee()})
        except ValueError as e:
            return jsonify({"error": str(e)}), 400
    return render_template('add_employee.html')

if __name__ == '__main__':
    app.run(debug=True)
