import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.inspirehubtask.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class FragmentDetails : Fragment() {

    companion object {
        private const val ZOOM_SCALE_FACTOR = 1.5f
//        تعريف ثابت ZOOM_SCALE_FACTOR بقيمة 1.2f، وهو المعامل الذي يحدد مقدار زيادة حجم النصوص عند الضغط على "zoom in"
    }

    @SuppressLint("ServiceCast", "MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_details, container, false)

        val bottomNavigationView =
            activity?.findViewById<BottomNavigationView>(R.id.id_bottomnavigation)
        val menu = bottomNavigationView?.menu
        val zoomInItem = menu?.findItem(R.id.zoom_in)
        val zoomOutItem = menu?.findItem(R.id.zoom_out)

        zoomInItem?.setOnMenuItemClickListener {
            zoomInTextSizes(view)
            true
        }

        zoomOutItem?.setOnMenuItemClickListener {
            zoomOutTextSizes(view)
            true
        }

        val textView = view.findViewById<TextView>(R.id.textview2)
      textView.setOnClickListener {
//            textView.text?.let { text ->
//                // Get the clipboard system service
//                val clipboard = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
//                // Create a clip with the text to be copied
//                val clip = ClipData.newPlainText("text", text)
//                // Set the clip to the clipboard
//                clipboard.setPrimaryClip(clip)
//
//                // Show a toast indicating successful copy
//                Toast.makeText(requireContext(), "Text copied", Toast.LENGTH_SHORT).show()
//            }
//        }

                    textView.text?.let { text ->
                // Create a clip with the text to be copied
                val clip = ClipData.newPlainText("text", text)
                        val clipboard = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

                // Get the clipboard system service

                // Set the clip to the clipboard
                clipboard.setPrimaryClip(clip)

                // Show a toast indicating successful copy
                Toast.makeText(requireContext(), "Text copied", Toast.LENGTH_SHORT).show()

                // Optionally, you can also change the background color of the TextView to indicate selection
                textView.setBackgroundColor(Color.YELLOW) // Change to whatever color you prefer
            }
      }


        val textview1 = view.findViewById<TextView>(R.id.textview1)
        val textview18 = view.findViewById<TextView>(R.id.textview18)
        val scrollView = view.findViewById<ScrollView>(R.id.scrollView)
        Log.d( "marize:",textview18.text.toString())
        textview1?.setOnClickListener {
            scrollView.post {
                scrollView.scrollTo(0, textview18.bottom)
            }
        }
        return view
    }

    private fun zoomInTextSizes(view: View) {
        if (view is ViewGroup) {
            val viewGroup = view
            val childCount = viewGroup.childCount
            for (i in 0 until childCount) {
                val childView = viewGroup.getChildAt(i)
                if (childView is TextView) {
                    val textView = childView
                    val textSize = textView.textSize
                    textView.setTextSize(textSize * ZOOM_SCALE_FACTOR)
                } else if (childView is ViewGroup) {
                    zoomInTextSizes(childView)
                }
            }
        }
    }

    private fun zoomOutTextSizes(view: View) {
        if (view is ViewGroup) {
            val viewGroup = view
            val childCount = viewGroup.childCount
            for (i in 0 until childCount) {
                val childView = viewGroup.getChildAt(i)
                if (childView is TextView) {
                    val textView = childView
                    val textSize = textView.textSize
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize / ZOOM_SCALE_FACTOR)
                } else if (childView is ViewGroup) {
                    zoomOutTextSizes(childView)
                }
            }
        }
    }
}
//import android.annotation.SuppressLint
//import android.content.ClipData
//import android.content.ClipboardManager
//import android.content.Context
//import android.graphics.Color
//import android.os.Bundle
//import android.util.TypedValue
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import android.widget.Toast
//import androidx.fragment.app.Fragment
//import com.example.inspirehubtask.R
//
//class FragmentDetails : Fragment() {
//
//    // Define enum for click behavior
//    enum class ClickAction {
//        HIGHLIGHT, // Highlight text in yellow
//        ENLARGE, // Enlarge text size
//        COPY // Copy text
//    }
//
//    // Initialize current click action
//    var currentClickAction = ClickAction.HIGHLIGHT // Default behavior
//
//    @SuppressLint("ServiceCast")
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val view = inflater.inflate(R.layout.fragment_details, container, false)
//
//        val textView = view.findViewById<TextView>(R.id.textview2)
//        textView.setOnClickListener {
//            textView.text?.let { text ->
//                when (currentClickAction) {
//                    ClickAction.HIGHLIGHT -> {
//                        // Highlight text in yellow
//                        textView.setBackgroundColor(Color.YELLOW)
//                    }
//                    ClickAction.ENLARGE -> {
//                        // Increase text size
//                        val currentSize = textView.textSize
//                        val newSize = currentSize + 5 // Change the increment as needed
//                        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, newSize)
//                    }
//                    ClickAction.COPY -> {
//                        // Copy text to clipboard
//                        val clip = ClipData.newPlainText("text", text)
//                        val clipboard = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
//                        clipboard.setPrimaryClip(clip)
//                        Toast.makeText(requireContext(), "Text copied", Toast.LENGTH_SHORT).show()
//                    }
//                }
//            }
//        }
//
//        return view
//    }
//
//    // Function to set the click behavior
//    fun setClickAction(action: ClickAction) {
//        currentClickAction = action
//    }
//}
