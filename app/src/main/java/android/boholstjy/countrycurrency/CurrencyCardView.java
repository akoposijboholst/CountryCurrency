package android.boholstjy.countrycurrency;

/**
 * Created by JustineYrvin on 1/12/2016.
 */

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CurrencyCardView extends RecyclerView.Adapter<CurrencyCardView.ViewHolder> {
    private List<Currency> currency;
    int position;

    public CurrencyCardView() {
        super();
        currency = new ArrayList<>();
    }

    public CurrencyCardView(List<Currency> currency) {
        this.currency = currency;
    }

    public void setmItems(List<Currency> currency) {
        this.currency = currency;
    }

    public void addCurrency(Currency currency) {
        if (currency == null) {
            return;
        }
        this.currency.add(currency);
    }

    public void remove() {
        if (currency.size() != 0) {
            currency.remove(0);
            notifyItemRemoved(0);
            notifyItemChanged(0);
            remove();
        }

    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.currency_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Currency item = currency.get(i);
            viewHolder.txtSub0.setText("Currency: " + item.getCurrency());
    }

    @Override
    public int getItemCount() {
        return currency.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtSub0;
        public ViewHolder(View v) {
            super(v);
            txtSub0 = (TextView) v.findViewById(R.id.tv_currency);
            //v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //here
        }
    }
}
