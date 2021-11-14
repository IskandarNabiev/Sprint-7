
import javax.persistence.*

@Entity
class Auto (

    @Id
    @GeneratedValue
    var id: Long = 0,

    var model: String,

    var color: String,

)  {

    override fun toString(): String {
        return "Auto(id=$id, model='$model', color='$color')"
    }
}
