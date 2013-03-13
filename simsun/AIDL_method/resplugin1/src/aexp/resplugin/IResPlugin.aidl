package aexp.resplugin;
import android.os.Bundle;

interface IResPlugin {
  Bundle onClick( in int id, in Bundle state );
}
