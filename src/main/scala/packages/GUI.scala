package packages

import GUI.stage
import javafx.scene.control.DatePicker
import javafx.scene.layout.BorderPane
import scalafx.application.JFXApp3
import scalafx.scene.Scene
import scalafx.scene.layout.Pane
import scalafx.scene.paint.Color.*
import scalafx.scene.control.{Button, CheckBox, Label, TextField, TextFormatter}
import scalafx.scene.text.Font
import scalafx.scene.control.TextFormatter.Change
import scalafx.scene.layout.StackPane
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.layout.VBox
import scalafx.scene.layout.HBox
import scalafx.scene.layout.GridPane
import scalafx.scene.layout.Background
import scalafx.scene.layout.BackgroundFill
import scalafx.scene.layout.CornerRadii
import scalafx.scene.layout.ColumnConstraints
import scalafx.scene.layout.RowConstraints
import scalafx.scene.paint.Color.*
import scalafx.Includes.*
import javafx.scene.control.{MenuBar, Menu, MenuItem, MenuButton}


object GUI extends JFXApp3:

  def start(): Unit =

    stage = new JFXApp3.PrimaryStage:
      title = "Rental Manager"
      width = 600
      height = 450

    val root = GridPane() // Simple pane component
    val scene = Scene(parent = root) // Scene acts as a container for the scene graph
    stage.scene = scene // Assigning the new scene as the current scene for the stage

      val label= Label("Items:") // Title label
      label.font = Font.font(20)
      val vebox = new VBox(label)
      root.add(vebox,0,2)





      val vbox= new HBox()
      root.add(vbox,0,1)

      val add= new Menu("add item")
      val a= new MenuItem("name:")
      val b= new MenuItem("description:")
      val c= new MenuItem("price:")
      val d= new MenuItem("hourlyprice:")
      val e= new MenuItem("dailyprice:")
      val f= new MenuItem("weeklyprice:")
      val g= new MenuItem("monthlyprice:")
      val h= new MenuItem("available count:")


      add.items= List(a,b,c,d,e,f,g,h)
      val remove = new Menu("remove item")
      val accountin = new Menu("accounting")
      val record= new Menu("records")


      val menubar= new MenuBar(add,remove,accountin,record)
        menubar.layoutY = 100
        menubar.prefWidth(600)
        vbox.children+=menubar



     // val date = new DatePicker(LocalDate.now)
     //vebox.children+=date


      val nameLabel = Label("Rental Manager") //Create a Label
      nameLabel.textFill = Black //Set text color
      nameLabel.font = Font.font(20) //Text font size. It is also possible to set font family.
      nameLabel.layoutX = 500
      root.children += nameLabel //Add label to GUI.




     /*val addItem= new Button("add item")
      addItem.layoutY = 100


      val removeItem= new Button("remove item")
      removeItem.layoutY=100
      removeItem.layoutX= 400

      val accounting= new Button("accounting")
      accounting.layoutY=100
      accounting.layoutX= 800

      val records= new Button("records")
      records.layoutY=100
      records.layoutX= 1200

      root.children+= addItem
      root.children+= removeItem
      root.children+= accounting
      root.children+= records*/