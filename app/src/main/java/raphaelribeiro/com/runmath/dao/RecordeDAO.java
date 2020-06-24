package raphaelribeiro.com.runmath.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import raphaelribeiro.com.runmath.modelo.Recordes;

public class RecordeDAO extends SQLiteOpenHelper {


    public RecordeDAO(@Nullable Context context) {
        super(context, "Runmath", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Resultados (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, placar INTEGER);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Resultados";
        db.execSQL(sql);
        onCreate(db);

    }

    public void insere(Recordes recorde) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("nome",recorde.getNome());
        dados.put("placar",recorde.getPontos());

        db.insert("Resultados",null, dados);
    }

    public List<Recordes> listarecordes() {
        String sql = "SELECT * FROM Resultados ORDER BY placar DESC;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);

        List<Recordes> recordes = new ArrayList<Recordes>();
        while (c.moveToNext()){
            Recordes recorde = new Recordes();
            recorde.setId(c.getLong(c.getColumnIndex("id")));
            recorde.setNome(c.getString(c.getColumnIndex("nome")));
            recorde.setPontos(c.getInt(c.getColumnIndex("placar")));

            recordes.add(recorde);
        }
        c.close();
        return recordes;
    }
}
